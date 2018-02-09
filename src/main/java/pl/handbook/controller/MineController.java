package pl.handbook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.handbook.entity.Mine;
import pl.handbook.entity.TypeOfMine;
import pl.handbook.repository.MineRepository;
import pl.handbook.repository.TypeOfMineRepository;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@Component
@RequestMapping("/mine")
public class MineController {

    @Autowired
    MineRepository mineRepository;

    private String headS = "Dodawnie miny";
    private String urlS = "/mine/save";
    private String headE = "Edycja miny";
    private String urlE = "/mine/update/save";

    @GetMapping("/all")
    public String allMines(Model m) {
        List<Mine> mines = mineRepository.findAll();
        m.addAttribute("mines", mines);
        m.addAttribute("typeOfMines", typeOfMines());
        return "all_mines";
    }

    @GetMapping("/add")
    public String addMine(Model m) {
        m.addAttribute("mine", new Mine());
        m.addAttribute("head", headS);
        m.addAttribute("url", urlS);
        m.addAttribute("typeOfMines", typeOfMines());
        return "new_mine_add";
    }

    @PostMapping("/save")
    public String saveMine(@Valid Mine mine, BindingResult result, @RequestPart(value = "photo") MultipartFile file, Model m) {
        m.addAttribute("head", headS);
        m.addAttribute("url", urlS);
        m.addAttribute("typeOfMines", typeOfMines());
        //  if (result.hasErrors()) {
        //      return "redirect:/mine/add";
        //  } else {
        uploadFile(file, mine);
        return "redirect:/mine/all";
        //  }
    }

    @GetMapping("/update/{id}")
    public String updateMine(Model m, @PathVariable Long id) {
        List<TypeOfMine> typeOfMines = typeOfMineRepository.findAll();
        m.addAttribute("typeOfMines", typeOfMines);
        m.addAttribute("head", headE);
        m.addAttribute("url", urlE);
        Mine mine = mineRepository.findOne(id);
        m.addAttribute(mine);
        return "new_mine_add";
    }

    @PostMapping("update/save")
    public String saveUpdateMine(@Valid Mine mine, BindingResult result, @RequestPart(value = "photo") MultipartFile file, Model m) {
        m.addAttribute("head", headE);
        m.addAttribute("url", urlE);
        m.addAttribute("typeOfMines", typeOfMines());
        //    if (result.hasErrors()) {
        //       return "redirect:/mine/add";
        //   } else {
        uploadFile(file, mine);
        return "redirect:/mine/all";
        //   }
    }

    @GetMapping("delete/{id}")
    public String deleteMine(@PathVariable long id) {
        mineRepository.delete(mineRepository.findOne(id));
        return "redirect:/mine/all";
    }

    @Autowired
    TypeOfMineRepository typeOfMineRepository;

    @ModelAttribute("typeOfMines")
    List<TypeOfMine> typeOfMines() {
        return typeOfMineRepository.findAll();
    }

    @GetMapping("/find")
    public String fineMine(@RequestParam(name = "name") String name, Model m) {
        Mine mine = mineRepository.findByName(name);
        m.addAttribute("mine", mine);
        m.addAttribute("typeOfMine", typeOfMineRepository.findByMine(mine));
        m.addAttribute("photo", mine.getPhoto());
        return "one_mine_view";
    }

    public void uploadFile(MultipartFile file, Mine mine) {
        if (!file.isEmpty()) {
            try {
                UUID uuid = UUID.randomUUID();
                String fileName = "/home/grzegorz/IdeaProjects/SappersHandbook/src/main/resources/tempPhoto/" + uuid.toString();
                byte[] bytes = file.getBytes();
                File isFile = new File(fileName);
                isFile.createNewFile();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(isFile));
                stream.write(bytes);
                stream.close();
                mine.setPhoto("http://localhost:8080/tempPhoto/img_" + uuid.toString() );
                mineRepository.save(mine);
            } catch (Exception e) {
                e.printStackTrace();
                mineRepository.save(mine);
            }
        }
    }


//    public void pobierz(Mine mine, HttpServletResponse response) throws IOException {
//        //    byte[] bytes = mine.getData(); //pobierz na podstawie id
//        FileInputStream inputStream = new FileInputStream(mine.getPhoto());
//        //    String headerValue = String.format("attachment; filename=\"%s\"", attachment.getOriginalFilename());
//        //   response.setHeader("Content-Disposition", headerValue);
//        OutputStream outStream = response.getOutputStream();
//        byte[] buffer = new byte[BUFFER_SIZE];
//        int bytesRead = -1; // czytamy w pętli po fragmencie, który następnie przepisujemy do strumienia wyjściowego
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            outStream.write(buffer, 0, bytesRead);
//        }
//        inputStream.close();
//        outStream.close();
//    }


//    public void uploadFile(MultipartFile file, Mine mine) {
//        if (!file.isEmpty()) {
//            try {
//                UUID uuid = UUID.randomUUID();
//                String fileName = uuid.toString();
//                String bucektName = "sapperhandbook";
//                String accessKey = "AKIAIZCHST7HC6HZ2KEA";
//                String secretKey = "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";
//                byte[] bytes = file.getBytes();
//                InputStream is = new ByteArrayInputStream(bytes);
//                AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//                AmazonS3Client s3Client = new AmazonS3Client(credentials);
//                s3Client.putObject(new PutObjectRequest(bucektName, fileName, is, new ObjectMetadata()));
//                mine.setPhoto(uuid.toString());
//                mineRepository.save(mine);
//            } catch (Exception e) {
//                e.printStackTrace();
//                mineRepository.save(mine);
//            }
//        }
//
//    }
}
