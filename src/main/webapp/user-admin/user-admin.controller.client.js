(function() {

    let userService = new AdminUserServiceClient()
    var $userRowTemplate, $tbody;

    var $firstNameFld, $lastNameFld, $roleFld;
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn, $updateBtn;
    var selectedUser

    let currentUserIndex = -1

    function main(){
        $usernameFld = $('#usernameFld')
        $passwordFld = $('#passwordFld')
        $firstNameFld = $('#firstNameFld')
        $lastNameFld = $('#lastNameFld')
        $roleFld = $('#roleFld')

        $tbody = $("tbody")
        $userRowTemplate= $('.wbdv-template')


        $createBtn = $('.wbdv-create')
        $createBtn.click(createUser)
        $updateBtn = $('.wbdv-update')
        $updateBtn.click(updateUser)



        $(findAllUsers())



    }
    $(main)

})()