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

package org.loboevolution.laf;


import com.mercuryred.render.interfaces.ui.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorMap {

    private static final Map<String, Color> COLOR_MAP = new HashMap<>();

    static {

        COLOR_MAP.put("transparent", com.mercuryred.ui.RenderEngines.Get().createColor(0, 0, 0, 0));
        COLOR_MAP.put("aliceblue", com.mercuryred.ui.RenderEngines.Get().createColor(240, 248, 255));
        COLOR_MAP.put("antiquewhite", com.mercuryred.ui.RenderEngines.Get().createColor(250, 235, 215));
        COLOR_MAP.put("aqua", com.mercuryred.ui.RenderEngines.Get().createColor(0, 255, 255));
        COLOR_MAP.put("aquamarine", com.mercuryred.ui.RenderEngines.Get().createColor(127, 255, 212));
        COLOR_MAP.put("azure", com.mercuryred.ui.RenderEngines.Get().createColor(240, 255, 255));
        COLOR_MAP.put("beige", com.mercuryred.ui.RenderEngines.Get().createColor(245, 245, 220));
        COLOR_MAP.put("bisque", com.mercuryred.ui.RenderEngines.Get().createColor(255, 228, 196));
        COLOR_MAP.put("black", com.mercuryred.ui.RenderEngines.Get().createColor(0, 0, 0));
        COLOR_MAP.put("blanchedalmond", com.mercuryred.ui.RenderEngines.Get().createColor(255, 235, 205));
        COLOR_MAP.put("blue", com.mercuryred.ui.RenderEngines.Get().createColor(0, 0, 255));
        COLOR_MAP.put("blueviolet", com.mercuryred.ui.RenderEngines.Get().createColor(138, 43, 226));
        COLOR_MAP.put("brown", com.mercuryred.ui.RenderEngines.Get().createColor(165, 42, 42));
        COLOR_MAP.put("burlywood", com.mercuryred.ui.RenderEngines.Get().createColor(222, 184, 135));
        COLOR_MAP.put("cadetblue", com.mercuryred.ui.RenderEngines.Get().createColor(95, 158, 160));
        COLOR_MAP.put("chartreuse", com.mercuryred.ui.RenderEngines.Get().createColor(127, 255, 0));
        COLOR_MAP.put("chocolate", com.mercuryred.ui.RenderEngines.Get().createColor(210, 105, 30));
        COLOR_MAP.put("coral", com.mercuryred.ui.RenderEngines.Get().createColor(255, 127, 80));
        COLOR_MAP.put("cornflowerblue", com.mercuryred.ui.RenderEngines.Get().createColor(100, 149, 237));
        COLOR_MAP.put("cornsilk", com.mercuryred.ui.RenderEngines.Get().createColor(255, 248, 220));
        COLOR_MAP.put("crimson", com.mercuryred.ui.RenderEngines.Get().createColor(220, 20, 60));
        COLOR_MAP.put("cyan", com.mercuryred.ui.RenderEngines.Get().createColor(0, 255, 255));
        COLOR_MAP.put("darkblue", com.mercuryred.ui.RenderEngines.Get().createColor(0, 0, 139));
        COLOR_MAP.put("darkcyan", com.mercuryred.ui.RenderEngines.Get().createColor(0, 139, 139));
        COLOR_MAP.put("darkgoldenrod", com.mercuryred.ui.RenderEngines.Get().createColor(184, 134, 11));
        COLOR_MAP.put("darkgray", com.mercuryred.ui.RenderEngines.Get().createColor(169, 169, 169));
        COLOR_MAP.put("darkgreen", com.mercuryred.ui.RenderEngines.Get().createColor(0, 100, 0));
        COLOR_MAP.put("darkgrey", com.mercuryred.ui.RenderEngines.Get().createColor(169, 169, 169));
        COLOR_MAP.put("darkkhaki", com.mercuryred.ui.RenderEngines.Get().createColor(189, 183, 107));
        COLOR_MAP.put("darkmagenta", com.mercuryred.ui.RenderEngines.Get().createColor(139, 0, 139));
        COLOR_MAP.put("darkolivegreen", com.mercuryred.ui.RenderEngines.Get().createColor(85, 107, 47));
        COLOR_MAP.put("darkorange", com.mercuryred.ui.RenderEngines.Get().createColor(255, 140, 0));
        COLOR_MAP.put("darkorchid", com.mercuryred.ui.RenderEngines.Get().createColor(153, 50, 204));
        COLOR_MAP.put("darkred", com.mercuryred.ui.RenderEngines.Get().createColor(139, 0, 0));
        COLOR_MAP.put("darksalmon", com.mercuryred.ui.RenderEngines.Get().createColor(233, 150, 122));
        COLOR_MAP.put("darkseagreen", com.mercuryred.ui.RenderEngines.Get().createColor(143, 188, 143));
        COLOR_MAP.put("darkslateblue", com.mercuryred.ui.RenderEngines.Get().createColor(72, 61, 139));
        COLOR_MAP.put("darkslategray", com.mercuryred.ui.RenderEngines.Get().createColor(47, 79, 79));
        COLOR_MAP.put("darkslategrey", com.mercuryred.ui.RenderEngines.Get().createColor(47, 79, 79));
        COLOR_MAP.put("darkturquoise", com.mercuryred.ui.RenderEngines.Get().createColor(0, 206, 209));
        COLOR_MAP.put("darkviolet", com.mercuryred.ui.RenderEngines.Get().createColor(148, 0, 211));
        COLOR_MAP.put("deeppink", com.mercuryred.ui.RenderEngines.Get().createColor(255, 20, 147));
        COLOR_MAP.put("deepskyblue", com.mercuryred.ui.RenderEngines.Get().createColor(0, 191, 255));
        COLOR_MAP.put("dimgray", com.mercuryred.ui.RenderEngines.Get().createColor(105, 105, 105));
        COLOR_MAP.put("dimgrey", com.mercuryred.ui.RenderEngines.Get().createColor(105, 105, 105));
        COLOR_MAP.put("dodgerblue", com.mercuryred.ui.RenderEngines.Get().createColor(30, 144, 255));
        COLOR_MAP.put("firebrick", com.mercuryred.ui.RenderEngines.Get().createColor(178, 34, 34));
        COLOR_MAP.put("floralwhite", com.mercuryred.ui.RenderEngines.Get().createColor(255, 250, 240));
        COLOR_MAP.put("forestgreen", com.mercuryred.ui.RenderEngines.Get().createColor(34, 139, 34));
        COLOR_MAP.put("fuchsia", com.mercuryred.ui.RenderEngines.Get().createColor(255, 0, 255));
        COLOR_MAP.put("gainsboro", com.mercuryred.ui.RenderEngines.Get().createColor(220, 220, 220));
        COLOR_MAP.put("ghostwhite", com.mercuryred.ui.RenderEngines.Get().createColor(248, 248, 255));
        COLOR_MAP.put("gold", com.mercuryred.ui.RenderEngines.Get().createColor(255, 215, 0));
        COLOR_MAP.put("goldenrod", com.mercuryred.ui.RenderEngines.Get().createColor(218, 165, 32));
        COLOR_MAP.put("gray", com.mercuryred.ui.RenderEngines.Get().createColor(128, 128, 128));
        COLOR_MAP.put("green", com.mercuryred.ui.RenderEngines.Get().createColor(0, 128, 0));
        COLOR_MAP.put("greenyellow", com.mercuryred.ui.RenderEngines.Get().createColor(173, 255, 47));
        COLOR_MAP.put("grey", com.mercuryred.ui.RenderEngines.Get().createColor(128, 128, 128));
        COLOR_MAP.put("honeydew", com.mercuryred.ui.RenderEngines.Get().createColor(240, 255, 240));
        COLOR_MAP.put("hotpink", com.mercuryred.ui.RenderEngines.Get().createColor(255, 105, 180));
        COLOR_MAP.put("indianred", com.mercuryred.ui.RenderEngines.Get().createColor(205, 92, 92));
        COLOR_MAP.put("indigo", com.mercuryred.ui.RenderEngines.Get().createColor(75, 0, 130));
        COLOR_MAP.put("ivory", com.mercuryred.ui.RenderEngines.Get().createColor(255, 255, 240));
        COLOR_MAP.put("khaki", com.mercuryred.ui.RenderEngines.Get().createColor(240, 230, 140));
        COLOR_MAP.put("lavender", com.mercuryred.ui.RenderEngines.Get().createColor(230, 230, 250));
        COLOR_MAP.put("lavenderblush", com.mercuryred.ui.RenderEngines.Get().createColor(255, 240, 245));
        COLOR_MAP.put("lawngreen", com.mercuryred.ui.RenderEngines.Get().createColor(124, 252, 0));
        COLOR_MAP.put("lemonchiffon", com.mercuryred.ui.RenderEngines.Get().createColor(255, 250, 205));
        COLOR_MAP.put("lightblue", com.mercuryred.ui.RenderEngines.Get().createColor(173, 216, 230));
        COLOR_MAP.put("lightcoral", com.mercuryred.ui.RenderEngines.Get().createColor(240, 128, 128));
        COLOR_MAP.put("lightcyan", com.mercuryred.ui.RenderEngines.Get().createColor(224, 255, 255));
        COLOR_MAP.put("lightgoldenrodyellow", com.mercuryred.ui.RenderEngines.Get().createColor(250, 250, 210));
        COLOR_MAP.put("lightgray", com.mercuryred.ui.RenderEngines.Get().createColor(211, 211, 211));
        COLOR_MAP.put("lightgreen", com.mercuryred.ui.RenderEngines.Get().createColor(144, 238, 144));
        COLOR_MAP.put("lightgrey", com.mercuryred.ui.RenderEngines.Get().createColor(211, 211, 211));
        COLOR_MAP.put("lightpink", com.mercuryred.ui.RenderEngines.Get().createColor(255, 182, 193));
        COLOR_MAP.put("lightsalmon", com.mercuryred.ui.RenderEngines.Get().createColor(255, 160, 122));
        COLOR_MAP.put("lightseagreen", com.mercuryred.ui.RenderEngines.Get().createColor(32, 178, 170));
        COLOR_MAP.put("lightskyblue", com.mercuryred.ui.RenderEngines.Get().createColor(135, 206, 250));
        COLOR_MAP.put("lightslategray", com.mercuryred.ui.RenderEngines.Get().createColor(119, 136, 153));
        COLOR_MAP.put("lightslategrey", com.mercuryred.ui.RenderEngines.Get().createColor(119, 136, 153));
        COLOR_MAP.put("lightsteelblue", com.mercuryred.ui.RenderEngines.Get().createColor(176, 196, 222));
        COLOR_MAP.put("lightyellow", com.mercuryred.ui.RenderEngines.Get().createColor(255, 255, 224));
        COLOR_MAP.put("lime", com.mercuryred.ui.RenderEngines.Get().createColor(0, 255, 0));
        COLOR_MAP.put("limegreen", com.mercuryred.ui.RenderEngines.Get().createColor(50, 205, 50));
        COLOR_MAP.put("linen", com.mercuryred.ui.RenderEngines.Get().createColor(250, 240, 230));
        COLOR_MAP.put("magenta", com.mercuryred.ui.RenderEngines.Get().createColor(255, 0, 255));
        COLOR_MAP.put("maroon", com.mercuryred.ui.RenderEngines.Get().createColor(128, 0, 0));
        COLOR_MAP.put("mediumaquamarine", com.mercuryred.ui.RenderEngines.Get().createColor(102, 205, 170));
        COLOR_MAP.put("mediumblue", com.mercuryred.ui.RenderEngines.Get().createColor(0, 0, 205));
        COLOR_MAP.put("mediumorchid", com.mercuryred.ui.RenderEngines.Get().createColor(186, 85, 211));
        COLOR_MAP.put("mediumpurple", com.mercuryred.ui.RenderEngines.Get().createColor(147, 112, 219));
        COLOR_MAP.put("mediumseagreen", com.mercuryred.ui.RenderEngines.Get().createColor(60, 179, 113));
        COLOR_MAP.put("mediumslateblue", com.mercuryred.ui.RenderEngines.Get().createColor(123, 104, 238));
        COLOR_MAP.put("mediumspringgreen", com.mercuryred.ui.RenderEngines.Get().createColor(0, 250, 154));
        COLOR_MAP.put("mediumturquoise", com.mercuryred.ui.RenderEngines.Get().createColor(72, 209, 204));
        COLOR_MAP.put("mediumvioletred", com.mercuryred.ui.RenderEngines.Get().createColor(199, 21, 133));
        COLOR_MAP.put("midnightblue", com.mercuryred.ui.RenderEngines.Get().createColor(25, 25, 112));
        COLOR_MAP.put("mintcream", com.mercuryred.ui.RenderEngines.Get().createColor(245, 255, 250));
        COLOR_MAP.put("mistyrose", com.mercuryred.ui.RenderEngines.Get().createColor(255, 228, 225));
        COLOR_MAP.put("moccasin", com.mercuryred.ui.RenderEngines.Get().createColor(255, 228, 181));
        COLOR_MAP.put("navajowhite", com.mercuryred.ui.RenderEngines.Get().createColor(255, 222, 173));
        COLOR_MAP.put("navy", com.mercuryred.ui.RenderEngines.Get().createColor(0, 0, 128));
        COLOR_MAP.put("oldlace", com.mercuryred.ui.RenderEngines.Get().createColor(253, 245, 230));
        COLOR_MAP.put("olive", com.mercuryred.ui.RenderEngines.Get().createColor(128, 128, 0));
        COLOR_MAP.put("olivedrab", com.mercuryred.ui.RenderEngines.Get().createColor(107, 142, 35));
        COLOR_MAP.put("orange", com.mercuryred.ui.RenderEngines.Get().createColor(255, 165, 0));
        COLOR_MAP.put("orangered", com.mercuryred.ui.RenderEngines.Get().createColor(255, 69, 0));
        COLOR_MAP.put("orchid", com.mercuryred.ui.RenderEngines.Get().createColor(218, 112, 214));
        COLOR_MAP.put("palegoldenrod", com.mercuryred.ui.RenderEngines.Get().createColor(238, 232, 170));
        COLOR_MAP.put("palegreen", com.mercuryred.ui.RenderEngines.Get().createColor(152, 251, 152));
        COLOR_MAP.put("paleturquoise", com.mercuryred.ui.RenderEngines.Get().createColor(175, 238, 238));
        COLOR_MAP.put("palevioletred", com.mercuryred.ui.RenderEngines.Get().createColor(219, 112, 147));
        COLOR_MAP.put("papayawhip", com.mercuryred.ui.RenderEngines.Get().createColor(255, 239, 213));
        COLOR_MAP.put("peachpuff", com.mercuryred.ui.RenderEngines.Get().createColor(255, 218, 185));
        COLOR_MAP.put("peru", com.mercuryred.ui.RenderEngines.Get().createColor(205, 133, 63));
        COLOR_MAP.put("pink", com.mercuryred.ui.RenderEngines.Get().createColor(255, 192, 203));
        COLOR_MAP.put("plum", com.mercuryred.ui.RenderEngines.Get().createColor(221, 160, 221));
        COLOR_MAP.put("powderblue", com.mercuryred.ui.RenderEngines.Get().createColor(176, 224, 230));
        COLOR_MAP.put("purple", com.mercuryred.ui.RenderEngines.Get().createColor(128, 0, 128));
        COLOR_MAP.put("red", com.mercuryred.ui.RenderEngines.Get().createColor(255, 0, 0));
        COLOR_MAP.put("rosybrown", com.mercuryred.ui.RenderEngines.Get().createColor(188, 143, 143));
        COLOR_MAP.put("royalblue", com.mercuryred.ui.RenderEngines.Get().createColor(65, 105, 225));
        COLOR_MAP.put("saddlebrown", com.mercuryred.ui.RenderEngines.Get().createColor(139, 69, 19));
        COLOR_MAP.put("salmon", com.mercuryred.ui.RenderEngines.Get().createColor(250, 128, 114));
        COLOR_MAP.put("sandybrown", com.mercuryred.ui.RenderEngines.Get().createColor(244, 164, 96));
        COLOR_MAP.put("seagreen", com.mercuryred.ui.RenderEngines.Get().createColor(46, 139, 87));
        COLOR_MAP.put("seashell", com.mercuryred.ui.RenderEngines.Get().createColor(255, 245, 238));
        COLOR_MAP.put("sienna", com.mercuryred.ui.RenderEngines.Get().createColor(160, 82, 45));
        COLOR_MAP.put("silver", com.mercuryred.ui.RenderEngines.Get().createColor(192, 192, 192));
        COLOR_MAP.put("skyblue", com.mercuryred.ui.RenderEngines.Get().createColor(135, 206, 235));
        COLOR_MAP.put("slateblue", com.mercuryred.ui.RenderEngines.Get().createColor(106, 90, 205));
        COLOR_MAP.put("slategray", com.mercuryred.ui.RenderEngines.Get().createColor(112, 128, 144));
        COLOR_MAP.put("slategrey", com.mercuryred.ui.RenderEngines.Get().createColor(112, 128, 144));
        COLOR_MAP.put("snow", com.mercuryred.ui.RenderEngines.Get().createColor(255, 250, 250));
        COLOR_MAP.put("springgreen", com.mercuryred.ui.RenderEngines.Get().createColor(0, 255, 127));
        COLOR_MAP.put("steelblue", com.mercuryred.ui.RenderEngines.Get().createColor(70, 130, 180));
        COLOR_MAP.put("tan", com.mercuryred.ui.RenderEngines.Get().createColor(210, 180, 140));
        COLOR_MAP.put("teal", com.mercuryred.ui.RenderEngines.Get().createColor(0, 128, 128));
        COLOR_MAP.put("thistle", com.mercuryred.ui.RenderEngines.Get().createColor(216, 191, 216));
        COLOR_MAP.put("tomato", com.mercuryred.ui.RenderEngines.Get().createColor(255, 99, 71));
        COLOR_MAP.put("turquoise", com.mercuryred.ui.RenderEngines.Get().createColor(64, 224, 208));
        COLOR_MAP.put("violet", com.mercuryred.ui.RenderEngines.Get().createColor(238, 130, 238));
        COLOR_MAP.put("wheat", com.mercuryred.ui.RenderEngines.Get().createColor(245, 222, 179));
        COLOR_MAP.put("white", com.mercuryred.ui.RenderEngines.Get().createColor(255, 255, 255));
        COLOR_MAP.put("whitesmoke", com.mercuryred.ui.RenderEngines.Get().createColor(245, 245, 245));
        COLOR_MAP.put("yellow", com.mercuryred.ui.RenderEngines.Get().createColor(255, 255, 0));
        COLOR_MAP.put("yellowgreen", com.mercuryred.ui.RenderEngines.Get().createColor(154, 205, 50));
    }

    public static Map<String, Color> colorMap() {
        return COLOR_MAP;
    }
}
