package com.unrec.imdb.searcher.exception;

import com.unrec.imdb.searcher.model.Element;

public class WrongTypeException extends GraphQLException {

  public WrongTypeException(Element type, int id) {
    super(String.format("Title with id='%d' is not %s", id, type.getPrintName()));
  }
}