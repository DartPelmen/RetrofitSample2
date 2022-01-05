package edu.festu.yulia.ponomarchuk.retrofitsample.network

data class InfoModel(var id: String,
                    var resultType: String,
                    var image: String,
                    var title: String,
                    var description: String)

data class SearchRequest(
    var searchType: String,
    var expression: String,
    var results: MutableList<InfoModel>,
    var errorMessage: String)