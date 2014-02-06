package hibernate.filters

class TestTagLib {
    static defaultEncodeAs = 'html'
    //static encodeAsForTags = [tagName: 'raw']

	def hu = {
		render(model: [hu: 'foo'], template: '/tl/myTemplate')
	}
}
