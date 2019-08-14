import request from '@/utils/request'

    export function add(user) {
      return request({
        url: '/user/add',
        method: 'post',
        params: user
      })
    }
    export function update(user) {
  console.debug('修改z')
      console.debug(user)
      return request({
        url: '/user/update',
        method: 'post',
        params: user
      })
    }
        export function deleteUser(id) {
      return request({
        url: '/user/delete',
    method: 'post',
    params: { id }
  })
}



export function list(map) {
  return request({
    url: '/user/list',
    method: 'post',
    data: map
  })
}

export function updateArticle(data) {
  return request({
    url: '/article/update',
    method: 'post',
    data
  })
}
