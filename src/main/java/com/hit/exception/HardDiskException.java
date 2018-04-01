package com.hit.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Stack;

import com.hit.exception.HardDiskException.ActionError;

import java.io.IOException;
import java.lang.String;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;

@SuppressWarnings("unused")
public class HardDiskException  extends IOException{

@SuppressWarnings({ "unchecked", "rawtypes" })
private static List<ActionError> List = new ArrayList();

private static final long serialVersionUID = -6327773420350070699L;


	public static enum ActionError {
		PAGE_FAULT,PAGE_REPLACEMENT;

	}
	private ActionError status;
	public HardDiskException()
	{

	}
	public HardDiskException(String msg)
	{
		super(msg);
		
	}
	public HardDiskException(String msg, ActionError  status)
	{
		super(msg);
		this.status=status;

	}
	
	public static HardDiskException.ActionError[] values() 
	{
	for (HardDiskException.ActionError c : HardDiskException.ActionError.values()) {
			  System.out.println(c);
	}
		return values();
	}
	
	public static HardDiskException.ActionError valueOf(String name) throws IllegalArgumentException,NullPointerException
	{
		if (name.isEmpty())
		{
			throw new NullPointerException();
		}
		if (ActionError.valueOf(name)!=ActionError.PAGE_FAULT && ActionError.valueOf(name)!=ActionError.PAGE_FAULT)
		{
			throw new IllegalArgumentException();
		}
		return ActionError.valueOf(name);
	}
	
	
}
