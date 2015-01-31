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


public class Blur {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myRegion=0;
		String filename="img.jpg";
		
		System.out.println("Creating Thumb");
		try {
			BufferedImage originalImage = ImageIO.read(new File(filename));
			int height = originalImage.getHeight();
			int width = originalImage.getWidth();
			if(width<height){
				myRegion=width;
			}else{
				myRegion=height;
			}
			System.out.println(width+" : "+height+" -> "+myRegion);
			BufferedImage thumb = 
			Thumbnails.of(new File(filename))
			.antialiasing(Antialiasing.ON)
			.sourceRegion(Positions.CENTER, myRegion,myRegion)
			.size(200, 200)
			.outputQuality(1f)
			.resizer(Resizers.BICUBIC)
			.asBufferedImage();
			
		
		
		GaussianFilter gaussian = new GaussianFilter(12);
		BufferedImage blurredthumbnail = gaussian.filter(thumb, null);
		File outputfile = new File("blurredthumbnail.jpg");
		ImageIO.write(blurredthumbnail, "jpg", outputfile);
		System.out.println("Finished Thumb");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
