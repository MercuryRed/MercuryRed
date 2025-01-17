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

package com.loboevolution.store.laf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.loboevolution.store.DatabseSQLite;
import org.loboevolution.store.SQLiteCommon;

import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class LAFSettings.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LAFSettings implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(LAFSettings.class.getName());

	/** The Constant DB_PATH. */
	private static final String DB_PATH = DatabseSQLite.getDatabaseDirectory();

	/** The Acryl . */
	private boolean acryl = false;

	/** The Aero . */
	private boolean aero = true;

	/** The Aluminium . */
	private boolean aluminium = false;

	/** The Bernstein . */
	private boolean bernstein = false;

	/** The Bold . */
	private boolean bold = false;
	
	/** The Fast . */
	private boolean fast = false;
	
	/** The Graphite . */
	private boolean graphite = false;

	/** The HiFi . */
	private boolean hiFi = false;

	/** The Italic . */
	private boolean italic = false;
	
	/** The modern . */
	private boolean modern = false;

	/** The blackWhite . */
	private boolean blackWhite = false;

	/** The Italic . */
	private boolean whiteBlack = true;	

	/** The Color . */
	private Color color = Color.BLACK;

	/** The Luna . */
	private boolean luna = false;

	/** The McWin . */
	private boolean mcWin = false;

	/** The Mint . */
	private boolean mint = false;

	/** The Noire . */
	private boolean noire = false;

	/** The Smart . */
	private boolean smart = false;

	/** The Strikethrough . */
	private boolean strikethrough = false;

	/** The Subscript . */
	private boolean subscript = false;

	/** The Superscript . */
	private boolean superscript = false;

	/** The Texture . */
	private boolean texture = false;

	/** The Underline . */
	private boolean underline = false;

	/** The Font . */
	private String font = "TimesNewRoman";

	/** The Font Size . */
	private float fontSize = 16.0f;

	private final String LOOK_AND_FEEL =
			" SELECT DISTINCT acryl, aero, aluminium, bernstein, fast, graphite," +
					" 	    		 hiFi,luna, mcWin, mint, noire, smart, texture," +
					"	 			 subscript, superscript, underline, italic, strikethrough," +
					"				 fontSize, font, color, bold, modern, black, white" +
					" FROM LOOK_AND_FEEL";
	
	/**
	 * <p>getFonts.</p>
	 *
	 * @param type a {@link java.lang.String} object.
	 * @return an array of {@link java.lang.String} objects.
	 */
	public static String[] getFonts(String type) {
		final List<String> fonts = new ArrayList<>();
		final String query = "SELECT name FROM " + type;
		try (Connection conn = DriverManager.getConnection(DatabseSQLite.getDatabaseDirectory());
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs != null && rs.next()) {
				fonts.add(rs.getString(1));
			}
		} catch (final Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return fonts.toArray(new String[0]);
	}

	/**
	 * <p>getInstance.</p>
	 *
	 * @return the instance
	 */
	public LAFSettings getInstance() {
		LAFSettings laf = null;
		try (Connection conn = DriverManager.getConnection(DB_PATH);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(this.LOOK_AND_FEEL)) {
			while (rs != null && rs.next()) {
				laf = LAFSettings.builder().
						acryl(rs.getInt(1) == 1).
						aero(rs.getInt(2) == 1).
						aluminium(rs.getInt(3) == 1).
						bernstein(rs.getInt(4) == 1).
						fast(rs.getInt(5) == 1).
						graphite(rs.getInt(6) == 1).
						hiFi(rs.getInt(7) == 1).
						luna(rs.getInt(8) == 1).
						mcWin(rs.getInt(9) == 1).
						mint(rs.getInt(10) == 1).
						noire(rs.getInt(11) == 1).
						smart(rs.getInt(12) == 1).
						texture(rs.getInt(13) == 1).
						subscript(rs.getInt(14) == 1).
						superscript(rs.getInt(15) == 1).
						underline(rs.getInt(16) == 1).
						italic(rs.getInt(17) == 1).
						strikethrough(rs.getInt(18) == 1).
						fontSize(Float.parseFloat(rs.getString(19))).
						font(rs.getString(20)).
						color(Color.BLACK).
						bold(rs.getInt(22) == 1).
						modern(rs.getInt(23) == 1).
						blackWhite(rs.getInt(24) == 1).
						whiteBlack(rs.getInt(25) == 1).build();
			}
		} catch (final Exception e) {
			return this;
		}
		return laf;
	}
}
