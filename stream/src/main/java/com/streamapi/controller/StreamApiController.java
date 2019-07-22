package com.streamapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streamapi.model.IntegerListRequest;
import com.streamapi.model.ListRequest;
import com.streamapi.model.Person;
import com.streamapi.model.StringListRequest;
import com.streamapi.service.StreamApiService;

@RestController
@RequestMapping("/stream-api")
public class StreamApiController {
	
	@Autowired
	private StreamApiService service;
	
	@GetMapping("/get-sum")
	public Integer getSumOfList(@RequestBody @Valid IntegerListRequest request) {
		return service.getSum(request);
	}
	
	@GetMapping("/foreach-example")
	public List<String> forEachExample(@RequestBody @Valid ListRequest request){
		return service.forEachExample(request);
	}
	
	@GetMapping("/filter-example")
	public List<String> filterExample(@RequestBody @Valid StringListRequest request){
		return service.filterExample(request);
	}
	
	@GetMapping("/sorted-example")
	public List<Integer> sortExample(@RequestBody @Valid IntegerListRequest request){
		return service.sortExample(request);
	}
	
	@GetMapping("/distinct-example")
	public List<Integer> distinctExample(@RequestBody @Valid IntegerListRequest request){
		return service.distinctExample(request);
	}
	
	@GetMapping("/map-example")
	public List<String> mapExample(@RequestBody @Valid StringListRequest request){
		return service.mapExample(request);
	}
	
	@GetMapping("/reduce-example")
	public Double reduceExample(@RequestBody @Valid List<Person> request) {
		return service.reduceExample(request);
	}
	
	@GetMapping("/parallel-example")
	public List<Integer> parallelExample(@RequestBody @Valid IntegerListRequest request){
		return service.parallelExample(request);
	}

}
