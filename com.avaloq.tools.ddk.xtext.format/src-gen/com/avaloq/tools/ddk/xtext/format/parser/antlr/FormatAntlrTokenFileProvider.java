/*
 * generated by Xtext 2.25.0
 */
package com.avaloq.tools.ddk.xtext.format.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class FormatAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("com/avaloq/tools/ddk/xtext/format/parser/antlr/internal/InternalFormat.tokens");
	}
}
