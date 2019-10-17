package com.kakinari.core.datatype.interfaces;

/*
 * JSON出力時に単純なエンコーディングではなく、異なる方法で出力したい場合に実装
 */
public interface JSONOutput {
	public String toJSONString();
	public String toJSONString(boolean beautify);
	public String toJSONString(int indent);
	public String toJSONString(int indent, boolean beautify);
}
