package dev.fileupload.util;

import java.io.File;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class FileNameUtils {

	// 업로드 가능한 파일 확장자
    private static final Set<String> ALLOWED_EXT = Set.of("jpg","jpeg","png","gif","pdf","txt","zip","csv","xlsx","docx");

	// 파일확장자 반환
    public static String getExtension(String filename) {
        if (filename == null) return "";
        int dot = filename.lastIndexOf('.');
        return (dot >= 0 && dot < filename.length() - 1) ? filename.substring(dot + 1).toLowerCase() : "";
    }

	// 파일 확장자 체크
    public static boolean isAllowedExt(String ext) {
        return ALLOWED_EXT.contains(ext);
    }
    
    /**
     * 업로드 경로 생성
     *	boardId가 비어있지 않으면 boardId/년/월/일
     *	boardId가 비어있으면 userId
     * @param boardId 게시판 ID (nullable)
     * @param userId  사용자 ID (nullable 아님)
     * @return OS에 맞춘 Path 객체
     */
    public static String generateUploadPath(String upload_dir, String boardId, String userId) {
        LocalDate today = LocalDate.now();
        String year = String.valueOf(today.getYear());
        // 2자리로 출력될수 있도록 형식문자를 지정
        String month = String.format("%02d", today.getMonthValue());
        String day = String.format("%02d", today.getDayOfMonth());

        String baseFolder = (boardId != null && !boardId.isBlank())
                ? boardId + File.separator + year + File.separator + month + File.separator + day + File.separator : userId;

        File path = new File(upload_dir + baseFolder);
        if(!path.exists()) {
        	// 디렉터리가 없다면 디렉터리 생성
        	path.mkdirs();
        }
        
        return upload_dir + baseFolder;
    }
    
    /**
     * 원본 파일명에 UUID를 붙여 새로운 파일명을 반환
     * 예) "profile.png" → "550e8400-e29b-41d4-a716-446655440000.png"
     *
     * @param originalName 원본 파일명
     * @return UUID 기반 새 파일명
     */
	public static String getStoreName(String originalFilename) {
		int index = originalFilename.lastIndexOf(".");
		String fileName = originalFilename.substring(0,index);
		String extension = originalFilename.substring(index);
        String uuid = UUID.randomUUID().toString();

		return fileName + "_" + uuid + "_" + extension;
	}
}