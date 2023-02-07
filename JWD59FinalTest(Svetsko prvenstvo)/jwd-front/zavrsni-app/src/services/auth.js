import ZavrsniAxios from '../apis/ZavrsniAxios'
import jwt_decode from "jwt-decode"

export const login = async function (username, password) {
    const cred = {
        username: username,
        password: password
    }

    try {
        const ret = await ZavrsniAxios.post('korisnici/auth', cred);
        const jwt_decoded = jwt_decode(ret.data);
        window.localStorage.setItem('jwt', ret.data);
        window.localStorage.setItem('role', jwt_decoded.role.authority);
        window.location.reload();
        window.location.assign("/");
    } catch (err) {
        alert("Neuspesan login");
        console.log(err);
    }
}

export const logout = function () {
    window.localStorage.removeItem('jwt');
    window.localStorage.removeItem('role');
    window.location.reload();
    window.location.assign("/");
}
