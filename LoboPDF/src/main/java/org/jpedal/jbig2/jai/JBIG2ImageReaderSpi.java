/**
 * ===========================================
 * Java Pdf Extraction Decoding Access Library
 * ===========================================
 *
 * Project Info:  http://www.jpedal.org
 * (C) Copyright 1997-2008, IDRsolutions and Contributors.
 * Main Developer: Simon Barnett
 *
 * 	This file is part of JPedal
 *
 * Copyright (c) 2008, IDRsolutions
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the IDRsolutions nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY IDRsolutions ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL IDRsolutions BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Other JBIG2 image decoding implementations include
 * jbig2dec (http://jbig2dec.sourceforge.net/)
 * xpdf (http://www.foolabs.com/xpdf/)
 * 
 * The final draft JBIG2 specification can be found at http://www.jpeg.org/public/fcd14492.pdf
 * 
 * All three of the above resources were used in the writing of this software, with methodologies,
 * processes and inspiration taken from all three.
 *
 * ---------------
 * JBIG2ImageReaderSpi.java
 * ---------------
 */
package org.jpedal.jbig2.jai;

import com.mercuryred.render.interfaces.imageio.ImageReader;
import com.mercuryred.render.interfaces.imageio.spi.ImageReaderSpi;
import com.mercuryred.render.interfaces.imageio.stream.ImageInputStream;

import java.io.IOException;
import java.util.Arrays;

/**
 * <p>JBIG2ImageReaderSpi class.</p>
 *
  *
  *
 */
public class JBIG2ImageReaderSpi implements ImageReaderSpi {

	/**
	 * <p>Constructor for JBIG2ImageReaderSpi.</p>
	 */
	public JBIG2ImageReaderSpi() {
		init("JPedal", // vendorName
				"1.0", // version
				new String[] { "jbig2", "JBIG2" }, // names
				new String[] { "jb2", "jbig2", "JB2", "JBIG2" }, // suffixes
				new String[] { "image/x-jbig2", "image/x-jb2" }, // MIMETypes
				"org.jpedal.jbig2.jai.JBIG2ImageReader", // readerClassName
				new Class[] { ImageInputStream.class }, // inputTypes
				null, // writerSpiNames
				false, // supportsStandardStreamMetadataFormat
				null, // nativeStreamMetadataFormatName
				null, // nativeStreamMetadataFormatClassName
				null, // extraStreamMetadataFormatNames
				null, // extraStreamMetadataFormatClassNames
				false, // supportsStandardImageMetadataFormat
				null, // nativeImageMetadataFormatName
				null, // nativeImageMetadataFormatClassName
				null, // extraImageMetadataFormatNames
				null); // extraImageMetadataFormatClassNames
		
	}

	private void init(String jPedal, String s, String[] strings, String[] strings1, String[] strings2, String s1, Class[] classes, Object o, boolean b, Object o1, Object o2, Object o3, Object o4, boolean b1, Object o5, Object o6, Object o7, Object o8) {
		throw com.mercuryred.utils.Nyi.ReportNyi();
	}

	/** {@inheritDoc} */
	public boolean canDecodeInput(Object input) throws IOException {

		// The input source must be an ImageInputStream because the constructor
		// passes STANDARD_INPUT_TYPE (an array consisting of ImageInputStream)
		// as the only type of input source that it will deal with to its
		// superclass.
		
		if (!(input instanceof ImageInputStream))
			return false;

		ImageInputStream stream = (ImageInputStream) input;

		/** Read and validate the input source's header. */
		byte[] header = new byte[8];
		try {
			// The input source's current position must be preserved so that
			// other ImageReaderSpis can determine if they can decode the input
			// source's format, should this input source be unable to handle the
			// decoding. Because the input source is an ImageInputStream, its
			// mark() and reset() methods are called to preserve the current
			// position.

			stream.mark();
			stream.read(header);
			stream.reset();
		} catch (IOException e) {
			return false;
		}

		byte[] controlHeader = new byte[] { (byte) 151, 74, 66, 50, 13, 10, 26, 10 };

		return Arrays.equals(controlHeader, header);
	}

	/** {@inheritDoc} */
	public ImageReader createReaderInstance(Object extension) throws IOException {
		// Inform the JBIG2 image reader that this JBIG2 image reader SPI is the
		// originating provider -- the object that creates the JBIG2 image
		// reader.
		return new JBIG2ImageReader(this);
	}

	/** {@inheritDoc} */
	public String getDescription(java.util.Locale locale) {
		return "JPedal JBIG2 Image Decoder provided by IDRsolutions.  See http://www.jpedal.org/jbig.php";
	}
}
