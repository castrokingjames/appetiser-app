package au.com.appetiser.itunes.data.remote.response

data class SearchResponse(
        val resultCount: Int,
        val results: List<ResultResponse>
) {

    data class ResultResponse(
            var trackId: Int,
            var trackName: String,
            var trackPrice: Double,
            var artworkUrl100: String,
            var primaryGenreName: String,
            var longDescription: String
    )
}