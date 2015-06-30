package com.worknik.swagger.codegen.plugin;

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.wordnik.swagger.codegen.plugin.CodeGenMojo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CodeGenMojoTest {

	@Test
	public void shouldGenerateSourcesForBasicConfiguration() throws MojoExecutionException {

		// given
		CodeGenMojo mojo = new CodeGenMojo();
		ReflectionTestUtils.setField(mojo, "output", new File("generated-sources/swagger"));
		ReflectionTestUtils.setField(mojo, "inputSpec", "src/test/resources/petstore.yaml");
		ReflectionTestUtils.setField(mojo, "language", "java");
		ReflectionTestUtils.setField(mojo, "addCompileSourceRoot", false);

		// when
		mojo.execute();

		// then
		// check that the output folder and generated sources exist
		File file = new File("generated-sources");
		assertThat(file.exists(), is(true));
		assertThat(file.isDirectory(), is(true));

		file = new File("generated-sources/swagger/src/main/java/io/swagger/client/model/pet.java");
		assertThat(file.exists(), is(true));
		assertThat(file.isDirectory(), is(false));

		// TODO check that the source can be compiled
	}

	@Test(expected = RuntimeException.class)
	public void shouldFailForInputSpecNotFound() throws MojoExecutionException {

		// given
		CodeGenMojo mojo = new CodeGenMojo();
		ReflectionTestUtils.setField(mojo, "output", new File("generated-sources/swagger"));
		ReflectionTestUtils.setField(mojo, "inputSpec", "src/test/resources/not-found.yaml");
		ReflectionTestUtils.setField(mojo, "language", "java");
		ReflectionTestUtils.setField(mojo, "addCompileSourceRoot", false);

		// when
		mojo.execute();
	}
}
