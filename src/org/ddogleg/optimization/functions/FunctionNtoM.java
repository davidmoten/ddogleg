/*
 * Copyright (c) 2012-2013, Peter Abeles. All Rights Reserved.
 *
 * This file is part of DDogleg (http://ddogleg.org).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ddogleg.optimization.functions;

/**
 * Function which takes in N parameters as input and outputs M elements.  The number N is typically determined
 * by the number of parameters in a model, say 2 for a line in 2D (slope and intercept).  The number M is determined
 * by the number of observations, for M 2D points the output would be M variables representing the distance of
 * each point from the line.
 *
 * @author Peter Abeles
 */
public interface FunctionNtoM {

	/**
	 * Number of input elements.
	 */
	public int getN();

	/**
	 * Number of output elements.
	 */
	public int getM();

	/**
	 * Processes the input to compute the values found in the output array.
	 *
	 * @param input Parameters for input model.
	 * @param output Values of output give the model.
	 */
	public void process(double input[], double[] output);
}
