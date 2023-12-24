package com.example.pension.controller;

import com.example.pension.dto.FileDto;
import com.example.pension.dto.NoticeDto;
import com.example.pension.dto.QnaDto;
import com.example.pension.mappers.NoticeMapper;
import com.example.pension.service.NoticeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/board")
public class NoticeController {

    @Value("${noticeFileDir}")
    String noticeFileDir;

    @Autowired
    NoticeService noticeService;

    @Autowired
    NoticeMapper noticeMapper;

    @GetMapping("/notice")
    public String getNotice(Model model, @RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="searchType", defaultValue = "") String searchType, @RequestParam(value = "words", defaultValue = "") String words) {

        String searchQuery = noticeService.getSearch(searchType, words);

        model.addAttribute("cnt", noticeMapper.getListCount(searchQuery));
        model.addAttribute("list", noticeService.getNotice(page, searchType, words));
        model.addAttribute("page", noticeService.pageCal(page, searchType, words));

        // int MaxGrp = noticeMapper.getMaxGrp();
        // noticeDto.setBoardNoticeGrp(MaxGrp);


        return "sub_pages/sub_board/sub_notice/notice.html";
    }

    @GetMapping("/notice/write")
    public String getWriteNotice() {
        return "sub_pages/sub_board/sub_notice_write/noticeWrite.html";
    }

    @PostMapping("/notice/write")
    public String setWriteNotice(@ModelAttribute NoticeDto noticeDto, @RequestParam List<MultipartFile> boardNoticeFiles) throws IOException {
        // System.out.println(noticeDto.toString());

        if(!boardNoticeFiles.get(0).isEmpty()) {

            noticeService.setWriteNotice(noticeDto);
            int fileId = noticeDto.getBoardNoticeId();
            // System.out.println(fileId);

            String folderName = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());

            File makeFolder = new File(noticeFileDir + folderName);
            if (!makeFolder.exists()) {
                makeFolder.mkdir();
            }

            FileDto fileDto = new FileDto();
            for(MultipartFile mf : boardNoticeFiles) {
                String savedPathName = noticeFileDir + folderName;

                String originalName = mf.getOriginalFilename();
                String ext = originalName.substring(originalName.lastIndexOf("."));
                String uuid = UUID.randomUUID().toString();
                String savedFileName = uuid + ext;

                mf.transferTo(new File(savedPathName + "/" + savedFileName));

                fileDto.setId(fileId);
                fileDto.setOriginalName(originalName);
                fileDto.setSavedFileName(savedFileName);
                fileDto.setSavedPathName(savedPathName);
                fileDto.setFolderName(folderName);
                fileDto.setExt(ext);

                noticeMapper.setFiles(fileDto);
            }


        }else {
            noticeService.setWriteNotice(noticeDto);
        }

        return "redirect:/board/notice";
    }

    @GetMapping("/notice/view")
    public String getView(@RequestParam int id, @ModelAttribute NoticeDto noticeDto, Model model) {
        // System.out.println(id);
        noticeMapper.updateVisit(id);
        NoticeDto n = noticeMapper.getView(id, noticeDto);
        model.addAttribute("id", n.getBoardNoticeId());
        model.addAttribute("subject", n.getBoardNoticeSubject());
        model.addAttribute("writer", n.getBoardNoticeWriter());
        model.addAttribute("visit", n.getBoardNoticeVisit());
        model.addAttribute("regdate", n.getBoardNoticeRegdate());
        model.addAttribute("content", n.getBoardNoticeContent());
        model.addAttribute("files", noticeMapper.getFiles(id));

        return "sub_pages/sub_board/sub_notice_view/noticeView.html";
    }

    @GetMapping("/notice/update")
    public String getUpdate(@RequestParam int id, Model model, @ModelAttribute NoticeDto noticeDto) {
        // System.out.println(id);
        // noticeDto.setBoardNoticeId(id);
        NoticeDto n = noticeMapper.getView(id, noticeDto);
        // System.out.println(n);

        List<FileDto> files = noticeMapper.getFiles(id);
        System.out.println(files);

        if (files.isEmpty()) {
            System.out.println("null");
        } else {
            System.out.println("file_exist");
            model.addAttribute("files", files);
        }


        model.addAttribute("modify", n);
        model.addAttribute("id", id);

        return "sub_pages/sub_board/sub_notice_update/noticeUpdate.html";
    }

    @PostMapping("/notice/update")
    public String setUpdate(@RequestParam int id, @ModelAttribute NoticeDto noticeDto, @RequestParam List<MultipartFile> boardNoticeFiles) throws IOException {

        // System.out.println(noticeDto);
        System.out.println(id);


        List<FileDto> files = noticeMapper.getFiles(id);
        System.out.println(files);

        if (boardNoticeFiles.get(0).isEmpty()) {
            System.out.println("null");
            noticeMapper.setUpdate(noticeDto);
        } else {
            System.out.println("file_exist");
            for(FileDto fd: files) {
                File file = new File(fd.getSavedPathName() + "/" + fd.getSavedFileName());
                file.delete();
            }
            noticeMapper.setFilesDelete(id);

            int fileId = noticeDto.getBoardNoticeId();
            // System.out.println(fileId);

            String folderName = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());

            File makeFolder = new File(noticeFileDir + folderName);
            if (!makeFolder.exists()) {
                makeFolder.mkdir();
            }

            FileDto fileDto = new FileDto();
            for(MultipartFile mf : boardNoticeFiles) {
                String savedPathName = noticeFileDir + folderName;

                String originalName = mf.getOriginalFilename();
                String ext = originalName.substring(originalName.lastIndexOf("."));
                String uuid = UUID.randomUUID().toString();
                String savedFileName = uuid + ext;

                mf.transferTo(new File(savedPathName + "/" + savedFileName));

                fileDto.setId(fileId);
                fileDto.setOriginalName(originalName);
                fileDto.setSavedFileName(savedFileName);
                fileDto.setSavedPathName(savedPathName);
                fileDto.setFolderName(folderName);
                fileDto.setExt(ext);

                noticeMapper.setFiles(fileDto);
            }
        }

        return "redirect:/board/notice/view?id="+id;
    }

    @GetMapping("/notice/delete")
    public String getDelete(@RequestParam int id) {
        // System.out.println(id);
        noticeMapper.getNoticeDelete(id);
        List<FileDto> files = noticeMapper.getFiles(id);
        for(FileDto fd: files) {
            File file = new File(fd.getSavedPathName() + "/" + fd.getSavedFileName());
            file.delete();
        }
        noticeMapper.setFilesDelete(id);
        return "redirect:/board/notice";
    }
}
