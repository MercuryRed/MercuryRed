/*
 * GNU GENERAL LICENSE
 * Copyright (C) 2014 - 2021 Lobo Evolution
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either
 * verion 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General License for more details.
 *
 * You should have received a copy of the GNU General Public
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact info: ivan.difrancesco@yahoo.it
 */
package org.loboevolution.info;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * <p>PropertyInfo class.</p>
 */
@Data
public class PropertyInfo {

	/** The getter. */
	private Method getter;

	/** The setter. */
	private Method setter;

	/** The name. */
	private final String name;

	/** The propertyType. */
	private final Class propertyType;

	/**
	 * <p>Constructor for PropertyInfo.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param propType a {@link java.lang.Class} object.
	 */
	public PropertyInfo(String name, Class propType) {
		super();
		this.name = name;
		this.propertyType = propType;
	}
}
