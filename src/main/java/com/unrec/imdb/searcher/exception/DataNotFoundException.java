package com.unrec.imdb.searcher.exception;

import com.unrec.imdb.searcher.model.Element;

public class DataNotFoundException extends GraphQLException {

  public DataNotFoundException(Element type, int id) {
    super(String.format("No %s for %d were found", type.getPrintName(), id));
  }
}
