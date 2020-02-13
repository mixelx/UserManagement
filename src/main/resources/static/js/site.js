const createNewUser = () => {
    redirectTo('/user/new');
};

const redirectTo = url => {
    location.assign(url.replace(',', ''));
};