package in.co.madhur;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.jhlabs.image.GaussianFilter;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.resizers.Resizers;
import net.coobird.thumbnailator.resizers.configurations.Antialiasing;

/**
 * Demo to blur image using Gaussian Filter
 * @author madhur
 *
 */
public class Blur {
	
	public static void main(String[] args) {
		int myRegion=0;
		String filename="img.jpg";
		String outfile="blurredthumbnail.jpg";
		int size=200;
		
		System.out.println("Creating Thumb");
		try {


			ClassLoader classLoader = Blur.class.getClassLoader();
			InputStream file = classLoader.getResourceAsStream(filename);
			if(file==null)
			{
				System.out.println("Cannot read file");
				return;
			}

		
			BufferedImage originalImage = ImageIO.read(classLoader.getResourceAsStream(filename));
			int height = originalImage.getHeight();
			int width = originalImage.getWidth();
			if(width<height){
				myRegion=width;
			}else{
				myRegion=height;
			}
			
			
			BufferedImage thumb = 
			Thumbnails.of(file)
			.antialiasing(Antialiasing.ON)
			.sourceRegion(Positions.CENTER, myRegion,myRegion)
			.size(size, size)
			.outputQuality(1f)
			.resizer(Resizers.BICUBIC)
			.asBufferedImage();
			
		
		
		GaussianFilter gaussian = new GaussianFilter(12);
		BufferedImage blurredthumbnail = gaussian.filter(thumb, null);
		File outputfile = new File(outfile);
		ImageIO.write(blurredthumbnail, "jpg", outputfile);
		System.out.println("Finished Thumb");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
