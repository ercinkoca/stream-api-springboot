package com.streamapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.streamapi.model.IntegerListRequest;
import com.streamapi.model.ListRequest;
import com.streamapi.model.Person;
import com.streamapi.model.StringListRequest;
import com.streamapi.service.StreamApiService;

@Service
public class StreamApiServiceImpl implements StreamApiService {
	
	private List<String> stringResultList=new ArrayList<String>();
	private List<Integer> integerResultList=new ArrayList<Integer>();

	@Override
	public Integer getSum(@Valid IntegerListRequest request) {// to get sum of given Integer List
		Integer sum=request.getList().stream().mapToInt(Integer::intValue).sum();
		return sum;
	}

	@Override
	public List<String> forEachExample(@Valid ListRequest request) { // To retrieve each data that the list is filled in.
		stringResultList.clear();
		if(request.getStringList().size()>0) {
			request.getStringList().stream().forEach(str->{
				stringResultList.add(str);
			});
		}if(request.getIntegerList().size()>0) {
			request.getIntegerList().stream().forEach(str->{
				stringResultList.add(str.toString());
			});
		}
		return stringResultList;
	}

	@Override
	public List<String> filterExample(@Valid StringListRequest request) { // To filter data in that List.
		stringResultList=request.getList().stream().filter(name-> name.length()>4).collect(Collectors.toList());
		return stringResultList;
	}

	@Override
	public List<Integer> sortExample(@Valid IntegerListRequest request) { // To sort data in the list.
		integerResultList.clear();
		request.getList().stream().sorted().forEach(p->{
			integerResultList.add(p);
		});
		return integerResultList;
	}

	@Override
	public List<Integer> distinctExample(@Valid IntegerListRequest request) { 
		integerResultList.clear();
		request.getList().stream().distinct().forEach(p->{
			integerResultList.add(p);
		});
		return integerResultList;
	}

	@Override
	public List<String> mapExample(@Valid StringListRequest request) { // map example to UpperCase data in the given list.
		stringResultList.clear();
		stringResultList=request.getList().stream().map(String::toUpperCase).collect(Collectors.toList());
		return stringResultList;
	}

	@Override
	public Double reduceExample(@Valid List<Person> request) { // reduce example to get average that given List.
		Double result=request.stream().filter(Objects::nonNull).map(p->p.getAge()).map(Double::valueOf).reduce((double) 0, (a,b)->(a+b)/2);
		return result;
	}

	@Override
	public List<Integer> parallelExample(@Valid IntegerListRequest request) { // parallel stream example to get positive integers that given the list.
		integerResultList.clear();
		request.getList().parallelStream().filter(p->p>0).forEach(a->{
			integerResultList.add(a);
		});
		return integerResultList;
	}
	
	

}
