<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- footer.jsp 시작 -->
        <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top"> 
            <!-- footer -->
            <div class="col-md-4 d-flex align-items-center"> <a href="/" class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1" aria-label="Bootstrap"> <svg class="bi" width="30" height="24" aria-hidden="true"><use xlink:href="#bootstrap"></use></svg> </a> <span class="mb-3 mb-md-0 text-body-secondary">© 2025 Company, Inc</span> </div> <ul class="nav col-md-4 justify-content-end list-unstyled d-flex"> <li class="ms-3"><a class="text-body-secondary" href="#" aria-label="Instagram"><svg class="bi" width="24" height="24" aria-hidden="true"><use xlink:href="#instagram"></use></svg></a></li> <li class="ms-3"><a class="text-body-secondary" href="#" aria-label="Facebook"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"></use></svg></a></li> </ul> 
        </footer>
        
    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
            <h1 class="modal-title fs-5" id="modalLabel">Modal title</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body" id="modalBody">
            ...
        </div>
        <div class="modal-footer">
            <button id="modalCloseBtn" type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            <button type="button" class="btn btn-primary" id="modalSaveBtn">Save changes</button>
        </div>
        </div>
    </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>    
<script>
    // 전역변수
    myModal = new bootstrap.Modal(document.getElementById('myModal'));

    function showModal(title, msg){
        // 모달창 세팅
        modalLabel.innerText = title;
        modalBody.innerHTML = msg;
        modalSaveBtn.style.display = 'none';
        // 모달창 화면에 출력
        myModal.show();
    }
</script>
</body>
</html>