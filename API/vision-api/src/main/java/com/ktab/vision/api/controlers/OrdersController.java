package com.ktab.vision.api.controlers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktab.vision.api.resources.model.OrderResource;

@RestController
@RequestMapping(value = "/v1/orders")
public class OrdersController {

	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<OrderResource> getOrders() {
		OrderResource greeting = new OrderResource("Hello");
		greeting.add(linkTo(methodOn(OrdersController.class).getOrders()).withSelfRel());
		return new ResponseEntity<OrderResource>(greeting, HttpStatus.OK);
	}
}
