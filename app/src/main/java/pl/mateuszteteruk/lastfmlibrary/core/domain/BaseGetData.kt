package pl.mateuszteteruk.lastfmlibrary.core.domain

import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.AttrDto
import pl.mateuszteteruk.lastfmlibrary.core.entity.Description
import pl.mateuszteteruk.lastfmlibrary.core.entity.RequestData

/**
 * Base interactor used to fetch data from Last.fm
 */
abstract class BaseGetData<T> : BaseInteractor<RequestData, T> {

    abstract override suspend fun execute(requestData: RequestData): T

    fun mapDescription(attrDto: AttrDto): Description =
        Description(
            total = attrDto.total,
            page = attrDto.page,
            perPage = attrDto.perPage,
            totalPages = attrDto.totalPages
        )

}