import Shared
import SwiftUI

struct AboutView: View {
    @Environment(\.dismiss)
    private var dismiss
    @StateObject private var viewModel: AboutViewModel = Koin.instance.get()

    var body: some View {
        NavigationStack {
            AboutListView(items: viewModel.items)
                .navigationTitle("About Device")
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            dismiss()
                        } label: {
                            Text("Done")
                                .bold()
                        }
                    }
                }
        }
    }
}

extension AboutViewModel: ObservableObject {}

struct AboutView_Previews: PreviewProvider {
    static var previews: some View {
        AboutView()
    }
}
