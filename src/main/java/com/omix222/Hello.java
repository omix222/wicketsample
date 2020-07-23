package com.omix222;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Hello extends WebPage {
	private static final long serialVersionUID = 1L;

	public Hello(final PageParameters parameters) {
		super(parameters);
        add(new Label("message", "Hello Wicket 9.0!!!"));

	}
}
