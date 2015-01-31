package in.co.madhur;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.jhlabs.image.GaussianFilter;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.resizers.Resizers;
import net.coobird.thumbnailator.resizers.configurations.Antialiasing;

/**
 * Demo to blur an image using Java
 * @author madhur
 *
 */
public class Blur {
	
	public static void main(String[] args) {
		int myRegion=0;
		final String filename="/Users/madhur/Documents/workspace/blur-java/src/img.jpg";
		final int size=200;
		final String outFile = "blurredthumbnail.jpg";
		
		System.out.println("Creating Thumbnail");
		try {
			BufferedImage originalImage = ImageIO.read(new File(filename));
			int height = originalImage.getHeight();
			int width = originalImage.getWidth();
			if(width<height){
				myRegion=width;
			}else{
				myRegion=height;
			}

			BufferedImage thumb = 
			Thumbnails.of(new File(filename))
			.antialiasing(Antialiasing.ON)
			.sourceRegion(Positions.CENTER, myRegion,myRegion)
			.size(size, size)
			.outputQuality(1f)
			.resizer(Resizers.BICUBIC)
			.asBufferedImage();
			
		
		
		GaussianFilter gaussian = new GaussianFilter(12);
		BufferedImage blurredthumbnail = gaussian.filter(thumb, null);
		File outputfile = new File(outFile);
		ImageIO.write(blurredthumbnail, "jpg", outputfile);
		System.out.println("Finished generating Thumbnail");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
