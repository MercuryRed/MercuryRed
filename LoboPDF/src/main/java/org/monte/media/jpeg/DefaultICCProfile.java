package org.monte.media.jpeg;

import com.mercuryred.render.interfaces.ui.color.ICC_Profile;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * <p>DefaultICCProfile class.</p>
 *
  *
  *
 */
public class DefaultICCProfile {
	/**
	 * <p>getDefaultIccProfile.</p>
	 *
	 * @return a {@link com.mercuryred.render.interfaces.ui.color.ICC_Profile} object.
	 * @throws java.io.IOException if any.
	 */
	public static ICC_Profile getDefaultIccProfile() throws IOException {
		URL resource = DefaultICCProfile.class.getResource("/org/monte/media/jpeg/Generic_CMYK_Profile.icc");
		try (InputStream stream = resource.openStream()) {
			return ICC_Profile.getInstance(resource.openStream());
		}
	}
}
