/* -*- Mode: java; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

// API class

package org.mozilla.javascript.debug;

/**
 * This interface exposes debugging information from executable
 * code (either functions or top-level scripts).
 *
 *
 *
 */
public interface DebuggableScript
{
    /**
     * <p>isTopLevel.</p>
     *
     * @return a boolean.
     */
    public boolean isTopLevel();

    /**
     * Returns true if this is a function, false if it is a script.
     *
     * @return a boolean.
     */
    public boolean isFunction();

    /**
     * Get name of the function described by this script.
     * Return null or an empty string if this script is not a function.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFunctionName();

    /**
     * Get number of declared parameters in the function.
     * Return 0 if this script is not a function.
     *
     * @see #getParamAndVarCount()
     * @see #getParamOrVarName(int index)
     * @return a int.
     */
    public int getParamCount();

    /**
     * Get number of declared parameters and local variables.
     * Return number of declared global variables if this script is not a
     * function.
     *
     * @see #getParamCount()
     * @see #getParamOrVarName(int index)
     * @return a int.
     */
    public int getParamAndVarCount();

    /**
     * Get name of a declared parameter or local variable.
     * <code>index</code> should be less then {@link #getParamAndVarCount()}.
     * If <code>index&nbsp;&lt;&nbsp;{@link #getParamCount()}</code>, return
     * the name of the corresponding parameter, otherwise return the name
     * of variable.
     * If this script is not function, return the name of the declared
     * global variable.
     *
     * @param index a int.
     * @return a {@link java.lang.String} object.
     */
    public String getParamOrVarName(int index);

    /**
     * Get the name of the source (usually filename or URL)
     * of the script.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSourceName();

    /**
     * Returns true if this script or function were runtime-generated
     * from JavaScript using <code>eval</code> function or <code>Function</code>
     * or <code>Script</code> constructors.
     *
     * @return a boolean.
     */
    public boolean isGeneratedScript();

    /**
     * Get array containing the line numbers that
     * that can be passed to <code>DebugFrame.onLineChange()</code>.
     * Note that line order in the resulting array is arbitrary
     *
     * @return an array of {@link int} objects.
     */
    public int[] getLineNumbers();

    /**
     * <p>getFunctionCount.</p>
     *
     * @return a int.
     */
    public int getFunctionCount();

    /**
     * <p>getFunction.</p>
     *
     * @param index a int.
     * @return a {@link org.mozilla.javascript.debug.DebuggableScript} object.
     */
    public DebuggableScript getFunction(int index);

    /**
     * <p>getParent.</p>
     *
     * @return a {@link org.mozilla.javascript.debug.DebuggableScript} object.
     */
    public DebuggableScript getParent();

}
