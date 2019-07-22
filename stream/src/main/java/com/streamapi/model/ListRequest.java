package com.streamapi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRequest {
	
	List<Integer> integerList=new ArrayList<Integer>();
	List<String> stringList=new ArrayList<String>();

}
