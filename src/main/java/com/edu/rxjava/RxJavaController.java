package com.edu.rxjava;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Observable;
		
@RestController
public class RxJavaController {

	private String result = "";

	@RequestMapping(method = RequestMethod.GET, value = "/single")
	public String testOne() {

		String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
		Observable<String> observable = Observable.fromArray(letters);

		observable.subscribe(
		  i -> result += i,  //OnNext
		  Throwable::printStackTrace, //OnError
		  () -> result += "_Completed" //OnCompleted
		);
		return result;
	}
}
