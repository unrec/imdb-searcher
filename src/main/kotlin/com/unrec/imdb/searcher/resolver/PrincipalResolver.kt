package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Principal
import com.unrec.imdb.searcher.repository.NameRepository
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class PrincipalResolver(val nameRepository: NameRepository) : GraphQLResolver<Principal> {

    fun person(principal: Principal) = nameRepository.findById(principal.nameId)

}