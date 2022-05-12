package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.TestDataFactory.testAkaEntity
import com.unrec.imdb.searcher.model.AkaId
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AkaRepositoryTest(@Autowired val repository: AkaRepository) {

    @Test
    fun `Find Aka entity by composite Id`() {
        val actual = testAkaEntity()
        repository.save(actual)

        val expected = repository.findById(AkaId(actual.titleId, actual.ordering)).get()
        assertThat(expected, Matchers.samePropertyValuesAs(actual))
    }
}
