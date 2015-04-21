package biweekly.property;

import java.util.List;

import biweekly.ICalVersion;
import biweekly.Warning;
import biweekly.component.ICalComponent;

/*
 Copyright (c) 2013-2015, Michael Angstadt
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met: 

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer. 
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * Represents a property whose data model consists of a single Java object (such
 * as a String).
 * @author Michael Angstadt
 * @param <T> the value type (e.g. String)
 */
public class ValuedProperty<T> extends ICalProperty {
	protected T value;

	/**
	 * Creates a new valued property.
	 * @param value the property's value
	 */
	public ValuedProperty(T value) {
		setValue(value);
	}

	/**
	 * Gets the value of this property.
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Sets the value of this property.
	 * @param value the value
	 */
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	protected void validate(List<ICalComponent> components, ICalVersion version, List<Warning> warnings) {
		if (value == null) {
			warnings.add(Warning.validate(26));
		}
	}

	/**
	 * Gets the value of a {@link ValuedProperty}.
	 * @param property the property
	 * @return the property value (may be null) or null if the property is null
	 */
	public static <T> T getValue(ValuedProperty<T> property) {
		return (property == null) ? null : property.getValue();
	}
}
