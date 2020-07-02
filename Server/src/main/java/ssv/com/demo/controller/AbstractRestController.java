package ssv.com.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ssv.com.demo.controller.resource.ResourceFactory;

public abstract class AbstractRestController {

	@Autowired
	ModelMapper modelMapper;

	ResourceFactory resourceFactory;
}
