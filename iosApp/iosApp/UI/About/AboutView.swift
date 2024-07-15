import SwiftUI

struct AboutView: View {
  @Environment(\.dismiss)
  private var dismiss

  var body: some View {
    NavigationStack {
      Text("Hello World!")
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

struct AboutView_Previews: PreviewProvider {
  static var previews: some View {
    AboutView()
  }
}
