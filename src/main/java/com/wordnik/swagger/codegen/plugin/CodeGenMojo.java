package com.wordnik.swagger.codegen.plugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
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

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import com.wordnik.swagger.codegen.Codegen;

/**
 * Goal which generates client/server code from a swagger json definition.
 *
 * @goal generate
 * 
 * @phase generate-sources
 */
public class CodeGenMojo extends AbstractMojo {

	/**
	 * Location of the file.
	 * 
	 * @parameter expression="${project.build.directory}"
	 * @required
	 */
	private File output;

	/**
	 * Location of the swagger spec, as URL or file.
	 * 
	 * @parameter
	 * @required
	 */
	private String inputSpec;

	/**
	 * Folder containing the template files.
	 * 
	 * @parameter
	 * @required
	 */
	private File templateDirectory;

	/**
	 * Client language to generate.
	 * 
	 * @parameter
	 * @required
	 */
	private String language;

	public void execute() throws MojoExecutionException {
		String[] args = new String[] { "-l", language, "-o", output.toString(), "-i", inputSpec, "-t",
				templateDirectory.toString() };
		Codegen.main(args);
	}
}
