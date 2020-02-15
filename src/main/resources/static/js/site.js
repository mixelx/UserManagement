const createNewUser = () => {
    redirectTo('/user/new');
};

const redirectTo = url => {
    location.assign(url.replace(',', ''));
};

const changeUserStatus = userId => {
    $.ajax({
        url: `/user/switchStatus/${userId}`,
        method: 'POST',
        success: data => {
            $('#status').text(data);
            $('#blockBtn').text('Status: ' + data === 'ACTIVE' ? 'Block' : 'Unblock');
        }
    });
};

const showEditPage = userId => {
    redirectTo(`/user/${userId}/edit`);
};