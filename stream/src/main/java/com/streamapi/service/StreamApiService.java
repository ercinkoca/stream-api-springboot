package com.streamapi.service;

import java.util.List;

import javax.validation.Valid;

import com.streamapi.model.IntegerListRequest;
import com.streamapi.model.ListRequest;
import com.streamapi.model.Person;
import com.streamapi.model.StringListRequest;

public interface StreamApiService {

	Integer getSum(@Valid IntegerListRequest request);

	List<String> forEachExample(@Valid ListRequest request);

	List<String> filterExample(@Valid StringListRequest request);

	List<Integer> sortExample(@Valid IntegerListRequest request);

	List<Integer> distinctExample(@Valid IntegerListRequest request);

	List<String> mapExample(@Valid StringListRequest request);

	Double reduceExample(@Valid List<Person> request);

	List<Integer> parallelExample(@Valid IntegerListRequest request);

}
