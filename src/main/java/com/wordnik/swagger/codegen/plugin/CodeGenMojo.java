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
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import com.wordnik.swagger.codegen.Codegen;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Goal which generates client/server code from a swagger json definition.
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CodeGenMojo extends AbstractMojo {

	/**
	 * Location of the output directory.
	 */
    @Parameter(name = "output",
            property = "swagger.codegen.maven.plugin.output",
            defaultValue = "${project.build.directory}/generated-sources/swagger")
	private File output;

	/**
	 * Location of the swagger spec, as URL or file.
	 */
    @Parameter(name = "inputSpec", required = true)
	private String inputSpec;

	/**
	 * Folder containing the template files.
	 */
    @Parameter(name = "templateDirectory")
	private File templateDirectory;

	/**
	 * Client language to generate.
	 */
    @Parameter(name = "language", required = true)
	private String language;

    @Override
	public void execute() throws MojoExecutionException {
		List<String> argsList = new ArrayList<>();
		argsList.add("-l");
		argsList.add(language);
		argsList.add("-o");
		argsList.add(output.toString());
		argsList.add("-i");
		argsList.add(inputSpec);
		if (templateDirectory != null) {
			argsList.add("-t");
			argsList.add(templateDirectory.toString());
		}
		Codegen.main(argsList.toArray(new String[argsList.size()]));
	}
}
