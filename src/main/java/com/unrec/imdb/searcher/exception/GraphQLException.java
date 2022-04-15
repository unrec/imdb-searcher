package com.unrec.imdb.searcher.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.Collections;
import java.util.List;

public class GraphQLException extends RuntimeException implements GraphQLError {

  public GraphQLException(String message) {
    super(message);
  }

  @Override
  public List<SourceLocation> getLocations() {
    return Collections.emptyList();
  }

  @Override
  public ErrorClassification getErrorType() {
    return null;
  }
}
