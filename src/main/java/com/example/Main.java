/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import static javax.measure.unit.SI.KILOGRAM;
import javax.measure.quantity.Mass;
import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;

@RestController
@SpringBootApplication
public class Main {

	@Autowired
	private SampleDao dao;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "db", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Timestamp>> db() throws Exception {
		List<Timestamp> timestamps = dao.getTicks();

		return new ResponseEntity<List<Timestamp>>(timestamps, HttpStatus.OK);
	}

	@RequestMapping("/hello")
	String hello(Map<String, Object> model) {
		RelativisticModel.select();
		Amount<Mass> m = Amount.valueOf("12 GeV").to(KILOGRAM);
		model.put("science", "E=mc^2: 12 GeV = " + m.toString());
		return "hello";
	}

}
