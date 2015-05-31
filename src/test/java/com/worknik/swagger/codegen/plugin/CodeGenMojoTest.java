package com.worknik.swagger.codegen.plugin;

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.wordnik.swagger.codegen.plugin.CodeGenMojo;

public class CodeGenMojoTest {

	@Test
	public void basicConfiguration() throws MojoExecutionException {
		CodeGenMojo mojo = new CodeGenMojo();
		ReflectionTestUtils.setField(mojo, "output", new File("generated-sources/swagger"));
		ReflectionTestUtils.setField(mojo, "inputSpec", "src/test/resources/petstore.yaml");
		ReflectionTestUtils.setField(mojo, "language", "java");
		ReflectionTestUtils.setField(mojo, "addCompileSourceRoot", false);

		mojo.execute();

		// check that the output folder exists and that the source can be
		// compiled
	}
}
