package org.red5.demos.oflaDemo;

import java.io.File;
import java.io.IOException;

import org.red5.server.api.scope.IScope;
import org.red5.server.api.stream.IStreamFilenameGenerator;

public class CustomFilenameGenerator implements IStreamFilenameGenerator
{
	/** Path that will store recorded videos. */
	public String recordPath = "recordedStreams/";

	/** Path that contains VOD streams. */
	public String playbackPath = "videoStreams/";
	public boolean resolvesAbsolutePath = false; 
	public CustomFilenameGenerator(){
		System.out.println("sss");
		System.out.println("sss");
	}
	@Override
	public String generateFilename(IScope scope, String name,GenerationType type)
	{
		return generateFilename(scope, name, null, type);
	}

	@Override
	public String generateFilename(IScope scope, String name, String extension,GenerationType type)
	{
		String filename;
		if (extension != null)
		{
			name += extension;
		}
		if (type == GenerationType.RECORD)
		{
			filename = recordPath + name;
			//解决相对路径，录制flv文件生成问题
			if(!resolvesAbsolutePath)
			{	
				//this.getClass().getClassLoader().getResource("/").getPath();
				File f = new File(System.getProperty("red5.root") + filename);
				try {
					if(!f.exists())
						f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else
		{
			filename = playbackPath + name;
		}
		
		return filename;
	}
	
	@Override
	public boolean resolvesToAbsolutePath()
	{
		return resolvesAbsolutePath;
	}

	public String getRecordPath()
	{
		return recordPath;
	}

	public void setRecordPath(String recordPath)
	{
		this.recordPath = recordPath;
	}

	public String getPlaybackPath()
	{
		return playbackPath;
	}

	public void setPlaybackPath(String playbackPath)
	{
		this.playbackPath = playbackPath;
	}
	
	public boolean isResolvesAbsolutePath()
	{
		return resolvesAbsolutePath;
	}

	public void setResolvesAbsolutePath(boolean resolvesAbsolutePath)
	{
		this.resolvesAbsolutePath = resolvesAbsolutePath;
	}

}
