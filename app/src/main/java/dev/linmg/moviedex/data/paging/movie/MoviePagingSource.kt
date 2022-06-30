package dev.linmg.moviedex.data.paging.movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.linmg.moviedex.data.remote.MovieDbApi
import dev.linmg.moviedex.data.remote.dto.movies.MovieModel
import dev.linmg.moviedex.data.remote.dto.movies.toModel

class MoviePagingSource(
    private val movieDbApi: MovieDbApi
) : PagingSource<Int, MovieModel>() {
    override fun getRefreshKey(state: PagingState<Int, MovieModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        val currentPage = params.key ?: 1
        return try {
            val response = movieDbApi.getPopularMovies(page = currentPage)
            val endOfPaginationReached = response.totalPages == currentPage
            if (!endOfPaginationReached)
                LoadResult.Page(
                    data = response.results.map { it.toModel() },
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            else
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
