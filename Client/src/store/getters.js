const getters = {
    token: state => state.user.token,
    roles: state => state.user.roles,
    permission_routes: state => state.permission.routes
}
export default getters;