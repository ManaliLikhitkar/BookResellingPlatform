package com.login;

public class UserP 
{
	public String fname,lname,dep,pwd;
	public long mob;
	
	public void setfname(String fn)
	{
		fname=fn;
	}
	
	public void setpwd(String pw)
	{
		pwd=pw;
	}
	
	public void setlname(String ln)
	{
		lname=ln;
	}
	
	public void setdep(String d)
	{
		dep=d;
	}
	
	public void setmob(long m)
	{
		mob=m;
	}
	
	public String getfname()
	{
		return fname;
	}
	
	public String getlname()
	{
		return lname;
	}
	
	public String getdep()
	{
		return dep;
	}
	
	public long getmob()
	{
		return mob;
	}
}
