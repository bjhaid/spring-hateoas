/*
 * Copyright 2012 the original author or authors.
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
package org.springframework.hateoas;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Integration tests for {@link Link} marshaling.
 * 
 * @author Oliver Gierke
 */
public class LinkIntegrationTest extends AbstractMarshallingIntegrationTests {

	private static final String REFERENCE = "{\"rel\":\"something\",\"href\":\"location\"}";

	/**
	 * @see #14
	 */
	@Test
	public void writesLinkCorrectly() throws Exception {
		assertThat(write(new Link("location", "something")), is(REFERENCE));
	}

	/**
	 * @see #14
	 */
	@Test
	public void readsLinkCorrectly() throws Exception {

		Link result = read(REFERENCE, Link.class);
		assertThat(result.getHref(), is("location"));
		assertThat(result.getRel(), is("something"));
	}
}
