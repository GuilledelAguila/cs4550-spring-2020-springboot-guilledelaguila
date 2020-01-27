(function() {

    let userService = new AdminUserServiceClient()
    var $userRowTemplate, $tbody;

    var $firstNameFld, $lastNameFld, $roleFld;
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn, $updateBtn;
    var selectedUser


    let currentUserIndex = -1

    function findAllUsers() {
        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers(users)
            })
    }
    function renderUsers(users) {
        $tbody.empty()
        for(let u in users) {
            renderUser(u)

        }
    }
    function renderUser(u) {
        let user = users[u]
        let rowClone = $userRowTemplate.clone()
        rowClone.removeClass('wbdv-hidden')
        rowClone.find('.wbdv-username').html(user.username)
        rowClone.find('.wbdv-last-name').html(user.lastName)
        rowClone.find('.wbdv-first-name').html(user.firstName)
        rowClone.find('.wbdv-role').html(user.role)
        $removeBtn = rowClone.find('.wbdv-remove')
        $removeBtn.click(() => deleteUser(u))
        $editBtn = rowClone.find('.wbdv-edit')
        $editBtn.click(() => findUserById(u))

        $tbody.append(rowClone)
    }

    function deleteUser(index){
        let user = users[index]
        let userId = user._id
        userService.deleteUser(userId)
            .then(response => {
                users.splice(index, 1)
                //renderUsers()
                findAllUsers()
            })
    }

    function main(){
        $usernameFld = $('#usernameFld')
        $passwordFld = $('#passwordFld')
        $firstNameFld = $('#firstNameFld')
        $lastNameFld = $('#lastNameFld')
        $roleFld = $('#roleFld')

        $tbody = $("tbody")
        $userRowTemplate= $('.wbdv-template')


        // $createBtn = $('.wbdv-create')
        // $createBtn.click(createUser)
        // $updateBtn = $('.wbdv-update')
        // $updateBtn.click(updateUser)



        $(findAllUsers())



    }
    $(main)

})()